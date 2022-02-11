CC = gcc
CFLAGS = -g -Wall
EXEC = a2

$(EXEC):
	$(CC) $(CFLAGS) -o $(EXEC) command.c input.c
clean:
	-rm $(EXEC)
	-rm *.exe
test:
	$(CC) $(CFLAGS) -o test command.c input.c
cleantest:
	-rm test
	-rm *.exe
