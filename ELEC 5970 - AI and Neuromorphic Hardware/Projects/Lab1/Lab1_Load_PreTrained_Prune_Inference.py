###-----------Imports--------------------------
import torch
from torch import nn
import torch.nn.utils.prune as prune
import torch.nn.functional as F
import numpy as np
import torch
import torchvision
import matplotlib.pyplot as plt
from time import time
from torchvision import datasets, transforms
from torch import nn, optim
####------------------------------------------


##-------------defining the model structure for loading the pretrained model-----------------
## Note: model structure must match the original pre-trained model being loaded
input_size = 784
hidden_sizes = [64, 64]
output_size = 10

model = nn.Sequential(nn.Linear(input_size, hidden_sizes[0]),
                      nn.ReLU(),
                      nn.Linear(hidden_sizes[0], hidden_sizes[1]),
                      nn.ReLU(),
                      nn.Linear(hidden_sizes[1], output_size),
                      nn.LogSoftmax(dim=1))


model = torch.load('trained_model.pt')
print (model)
###------------------------------------------------------------------------------------------


###---------------Defining the functions------------------------------------------------------
transform = transforms.Compose([transforms.ToTensor(),
                              transforms.Normalize((0.5,), (0.5,)),
                              ])

def view_classify(img, ps):
    ''' Function for viewing an image and it's predicted classes.
    '''
    ps = ps.data.numpy().squeeze()

    fig, (ax1, ax2) = plt.subplots(figsize=(6,9), ncols=2)
    ax1.imshow(img.resize_(1, 28, 28).numpy().squeeze())
    ax1.axis('off')
    ax2.barh(np.arange(10), ps)
    ax2.set_aspect(0.1)
    ax2.set_yticks(np.arange(10))
    ax2.set_yticklabels(np.arange(10))
    ax2.set_title('Class Probability')
    ax2.set_xlim(0, 1.1)
    plt.tight_layout()
    plt.show()
####-------------------------------------------------------------------------------------

### --------------Setting the path of Validation image folder-----------------------------
valset = datasets.MNIST(r"C:\Users\jacob\OneDrive - Auburn University\Current Classes\AI Hardware\Labs\Lab1\Lab1code\MNIST_DATASET", download=False, train=False, transform=transform)
valloader = torch.utils.data.DataLoader(valset, batch_size=64, shuffle=True)
###---------------------------------------------------------------------------------------


##------------------------------------Pruning the model-------------------------------
parameters_to_prune = ((model[0], 'weight'),(model[2], 'weight'), (model[4], 'weight'))             #defining the parameters to prune
prune.global_unstructured(parameters_to_prune, pruning_method=prune.L1Unstructured, amount = 0.0)   # setting the pruning method and pruning rate

##---------------Checking the sparsity of weight in each layer-------------------------
print(
    "Sparsity in Linear Layer 1: {:.2f}%".format(
        100. * float(torch.sum(model[0].weight == 0))
        / float(model[0].weight.nelement())
    )
)
print(
    "Sparsity in Linear Layer 2: {:.2f}%".format(
        100. * float(torch.sum(model[2].weight == 0))
        / float(model[2].weight.nelement())
    )
)

print(
    "Sparsity in Linear Layer 3: {:.2f}%".format(
        100. * float(torch.sum(model[4].weight == 0))
        / float(model[4].weight.nelement())
    )
)

print(
    "Global Sparsity: {:.2f}%".format(100.* ((float(torch.sum(model[0].weight == 0))) + (float(torch.sum(model[2].weight == 0))) + (float(torch.sum(model[4].weight == 0))))
                                      / (float(model[0].weight.nelement()) + float(model[2].weight.nelement()) + float(model[4].weight.nelement())))

)

####-----------------------------------------------------------------------------------


##--------------Single image testing with pruned model--------------------------------
images, labels = next(iter(valloader))
img = images[0].view(1, 784)
with torch.no_grad():
    logps = model(img)
ps = torch.exp(logps)
probab = list(ps.numpy()[0])
print("Predicted Digit =", probab.index(max(probab)))
view_classify(img.view(1, 28, 28), ps)
##-------------------------------------------------------------------------------------

##----------------Finding accuracy with pruned model-----------------------------------
correct_count, all_count = 0, 0
for images, labels in valloader:
    for i in range(len(labels)):
        img = images[i].view(1, 784)
        with torch.no_grad():
            logps = model(img)

        ps = torch.exp(logps)
        probab = list(ps.numpy()[0])
        pred_label = probab.index(max(probab))
        true_label = labels.numpy()[i]
        if (true_label == pred_label):
            correct_count += 1
        all_count += 1

print("Number Of Images Tested =", all_count)
print("\nModel Accuracy =", (correct_count / all_count) * 100, '%')
##-------------------------------------------------------------------------------