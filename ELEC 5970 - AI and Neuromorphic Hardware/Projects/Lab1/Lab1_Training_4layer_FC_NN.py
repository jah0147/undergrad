##----------Importing necessary packages-------------
import numpy as np
import torch
import torchvision
import matplotlib.pyplot as plt
from time import time
from torchvision import datasets, transforms
from torch import nn, optim

##--------------------------------------------------

##-----------Defining necessary functions---------------------------------------
##transform function converts the image into tensor and normalize the tensor
transform = transforms.Compose([transforms.ToTensor(),
                              transforms.Normalize((0.5,), (0.5,)),
                              ])
##view_classify fucntion shows the image and model's prediction probibility on it
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
    plt.show(block = False)
    plt.pause(3)
    plt.close()

###------------------------------------------------------------------------------


##------------------------downloading the trainig and testing dataset and storing them in DataLoader--------------------------------------------------------------
trainset = datasets.MNIST(r"C:\Users\jacob\OneDrive - Auburn University\Current Classes\AI Hardware\Labs\Lab1\Lab1code\MNIST_DATASET",
                          download=True, train=True, transform=transform)
valset = datasets.MNIST(r"C:\Users\jacob\OneDrive - Auburn University\Current Classes\AI Hardware\Labs\Lab1\Lab1code\MNIST_DATASET",
                        download=True, train=False, transform=transform)
trainloader = torch.utils.data.DataLoader(trainset, batch_size=512, shuffle=True)
valloader = torch.utils.data.DataLoader(valset, batch_size=512, shuffle=True)

####---------------------------------------------------------------------------------------------------------------------------------------------------------------

##-----Prinintg the shape of the images & Labels and Displaying a single image from the dataset--------------------
images, labels = next(iter(trainloader))
print(images.shape)
print(labels.shape)
#plt.imshow(images[0].numpy().squeeze(), cmap='gray_r')
plt.show(block = False)
plt.pause(4)
plt.close()
##-----------------------------------------------------------------------------------------------------------------

##----------Displaying 60 images at a time from the dataset---------------------------
num_of_images = 60
for index in range(1, num_of_images + 1 ):
    plt.subplot(6, 10, index)
    plt.axis('off')
   # plt.imshow(images[index].numpy().squeeze(), cmap='gray_r')
plt.show(block = False)
plt.pause(4)
plt.close()
##----------------------------------------------------------------------------------


##--------------------Defining & Printing the model--------------------------------------------
input_size = 784
hidden_sizes = [256, 256, 256]
output_size = 10

model = nn.Sequential(nn.Linear(input_size, hidden_sizes[0]),
                      nn.ReLU(),
                      #nn.Dropout(p=0.5),
                      nn.Linear(hidden_sizes[0], hidden_sizes[1]),
                      nn.ReLU(),
                      #nn.Dropout(p=0.5),
                      nn.Linear(hidden_sizes[1], output_size),
                      nn.LogSoftmax(dim=1))
print(model)
##---------------------------------------------------------------------------------------------


##----------------Defining the loss function and calculating the loss of input images----------
criterion = nn.NLLLoss()
images = images.view(images.shape[0], -1)    #flatteining the image into a 1d tensor
logps = model(images)                        #log probabilities
loss = criterion(logps, labels)              #calculate the NLL loss
##---------------------------------------------------------------------------------------------

##-------Printing the model weights & gradient of loss before and after one backprop-------------------------------------------------------------------
print('Initialized Random Weights of 1st layer before backprop: \n', model[0].weight)
print('Gradient of Loss (1st layer) before backward pass: \n', model[0].weight.grad)   #at first it is set to none as the model hasn't gone through any backprop yet
loss.backward()                                                          #calculates the gradient of loss using backprop algorithm to update the weights
print('Gradients (1st layer) After one backward pass: \n', model[0].weight.grad)
print('Weights (1st layer) After one backward pass: \n', model[0].weight)
##-------------------------------------------------------------------------------------------------------------------------------------------------------


##-----------------------------------------------------------------------------Setting the hyperparameters-------------------------------------------------------------------------
#optimizer = optim.Adam(model.parameters(), lr = 0.0001, betas= (0.9, 0.999))  # setting the optimizer, learining rate and betas for adam optimizer, you can also use other optimizers
optimizer = optim.SGD(model.parameters(), lr = 0.03, momentum=0.9)
time0 = time()
epochs = 25
E = []
L = []
for e in range(epochs):
    running_loss = 0
    c = 0
    for images, labels in trainloader:
        images = images.view(images.shape[0], -1)    # Flatten MNIST images into a 784 long vector

        # Training pass
        optimizer.zero_grad()         # setting the gradients to zero before starting backprop each time
        output = model(images)
        loss = criterion(output, labels)
        loss.backward()               # This is where the model learns by backpropagating
        #print('Weights after each backprop:', model[0].weight)     #you can uncomment this line to print the weighyts(1st layer) after each backprop
        optimizer.step()              # optimizes the weights

        running_loss += loss.item()
        c = c + 1
    else:
        print("Epoch {} - Training loss: {}".format(e, running_loss / len(trainloader)))     ## this is a cool feature of python3 which allows an else block without an if.
        E.append(e)                                                                          ## The structure is: at the last iteraton of the for loop the else block will be executed.
        L.append(running_loss / len(trainloader))                                            ## In this case, else is excuted at the last iteration of inner for loop.

print("Iterations in one Epoch", c)
print("\nTraining Time (in minutes) =", (time() - time0) / 60)

##---plots the graph of training loss vs epochs, comment it out if not needed
plt.plot(E, L)
plt.xlabel('Epochs')
plt.ylabel('Training Loss')
plt.show(block = False)
plt.pause(3)
plt.close()
##----------------------------------------------End of Training----------------------------------------------------------------------------------------


###--------------------------------------Starting pf validation phase---------------------------------------------
## Finding the prediction of a single image-----------------------------------------------------------------------
images, labels = next(iter(valloader))
img = images[0].view(1, 784)
with torch.no_grad():         # as we do not need to calculate the gradients in validation phase we used no_grad()
    logps = model(img)
ps = torch.exp(logps)
probab = list(ps.numpy()[0])
print("Predicted Digit =", probab.index(max(probab)))
view_classify(img.view(1, 28, 28), ps)
#------------------------------------------------------------------------------------------------------------------

##---------------------testing all images from the test folder & calculating model accuracy--------------------------
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
####------------------------End of Validation Phase-----------------------------------------------------------------

##--------------------Saving the tarined model----------------------------------------------------------------------
torch.save(model, './trained_model.pt')
##------------------------------------------------------------------------------------------------------------------