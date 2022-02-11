/*
 * COMP 3500: Project 5
 * Xiao Qin
 * Jacob Howard
 *
 * This source code shows how to pass commandline arguments to your progrm
 *
 * How to compile?
 * $gcc input.c -o command
 *
 * How to run?
 * Case 1: no argument. Sample usage is printed
 * $./input
 * Usage: input <file_name>
 *
 * Case 2: file doesn't exist.
 * $./input file1
 * File "file1" doesn't exist. Please try again...
 *
 * Case 3: Input file
 * $./input task.list
 * data in task.list is printed below...
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_TASK_NUM 32

typedef unsigned int u_int;

typedef struct task {
    u_int pid;
    u_int arrival_time;
    u_int burst_time;
} task_t;

typedef struct stat_info {
	u_int avg_waiting_time;
	u_int avg_trnd;
	u_int avg_response;
	u_int cpu_usage;
} stat_info_t;

typedef enum {FCFS, SRTF, RR} policy_t;

int task_info_loader(char *file_name, task_t *task_array, u_int count) {
	FILE *fp;
	if (!(fp = fopen(file_name, "r"))) {
		printf("File %s can't be opened. Please retry ...\n");
		return EXIT_FAILURE;
	}
	while (fscanf(fp, "%u %u %u", &task_array[count].pid, &task_array[count].arrival_time, \
		&task_array[count].burst_time) != EOF) {
		count++;
	}
	printf("There are %u tasks loaded from %s ...\n", count, file_name);
	fclose(fp);
	return EXIT_SUCCESS;
}

void fcfs_policy(task_t *task_array, stat_info_t stats, u_int count) {
	u_int avg_waiting_time = 0;
	u_int avg_trnd = 0;
	u_int avg_response = 0;
	u_int cpu_usage = 0;
	u_int cur_time = 0;
	for (int i = 0; i < count; i++) {
		u_int response = cur_time - task_array[i].arrival_time;
		u_int waiting_time = cur_time - task_array[i].arrival_time;
		u_int trnd = cur_time + task_array[i].burst_time;
		stats.avg_response += response;
		stats.avg_waiting_time += waiting_time;
		stats.avg_trnd += trnd;
		for(int j = 0; j < task_array[i].burst_time; j++) {
			printf("<time %u> process %u is running\n", cur_time, task_array[i].pid);
			cur_time++;
		}
		printf("<time %u> process %u is finished...\n", cur_time, task_array[i].pid);
	}
	stats.avg_response /= count;
	stats.avg_waiting_time /= count;
	stats.avg_trnd /= count;
}

void srtf_policy(task_t *task_array, task_t *finish_array, u_int count) {

}
void rr_policy(task_t *task_array, task_t *finish_array, u_int count, u_int quantum) {

}

void coordinator(policy_t policy, task_t *task_array, u_int count, u_int quantum) {

}

int main(int argc, char *argv[]) {
	char *file_name; /* file name from the commandline */
	task_t task_array[MAX_TASK_NUM];
	task_t finish_array[MAX_TASK_NUM];
	u_int i;
	u_int count = 0;
	u_int quantum;

	if (argc <= 3) {
		printf("Usage: scheduler task_list_file [FCFS|RR|SRTF] [time_quantum]\n");
		return EXIT_FAILURE;
	}
	file_name = argv[1];
	if (strcmp(argv[2], "RR") == 0) {
		if (argc == 4) {
			printf("time_quantum is set to %s\n", argv[3]);
			quantum = argv[3];
		}
		else {
			printf("Please enter time_quantum for the RR policy!\n");
			return EXIT_FAILURE;
		}
	}
	/*read and load task input file
	  if file is corrupt, end program abnormally*/
	int exit_value = task_info_loader(file_name, task_array, count);
	if (exit_value != EXIT_SUCCESS) {
		return exit_value;
	}
	printf("Press any key to continue ...\n");
	getchar();


	return EXIT_SUCCESS;
}
