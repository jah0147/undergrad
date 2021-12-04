module IntructionMemory(
input [15:0] PC_out,
//output [15:0] data, //outup
output [15:0] InstructionMemOut
);

reg [15:0] ROM [0:65535];
initial $readmemb("instruction.mem", ROM);

assign InstructionMemOut = ROM[PC_out];
//assign InstructionMemOut = data;
endmodule