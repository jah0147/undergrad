`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 11/11/2021 11:27:07 PM
// Design Name: 
// Module Name: cpu
// Project Name: 
// Target Devices: 
// Tool Versions: 
// Description: 
// 
// Dependencies: 
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
//////////////////////////////////////////////////////////////////////////////////


module CPU(
input clk,
input reset,
input [2:0] Inr,
output [15:0] OutValue,
//output [15:0] PC,
output [1:0] MemOp,
output [15:0] MemAddr,
input [15:0] MemReadData,
output [15:0] MemWriteData,

output [15:0] r1,
output [15:0] r2,
output [15:0] ALUout,

output [15:0] PC_out,
output [15:0] Instruction,

output [15:0] mux1,

output [15:0] PCAdderOut,

output [15:0] mux2out,

output [15:0] signExtout,

output[15:0] adder2out,

output branchGate,
output branchGateout,

output branch, //andGate input
output jump, //mux1 input
output mem_read_write, //data mem input
output mem_to_reg, //mux3 input
output [2:0] ALUOp, //1-6
output ALUSrc, //mux2 input
output RegWrite, //RegFile input
output halt, //PC input

output [4:0] ALUControlOut, //alu input

output [15:0] mux3out
);

RegisterFile registerFile(.clk(clk), .reset(reset), .r1(r1), .r2(r2),
.Instruction(Instruction), .RegWrite(RegWrite), .mux3out(mux3out));

ALU alu(.r1(r1), .ALUControl(ALUControlOut), .mux2(mux2out), .ALUout(ALUout), .branchGate(branchGate));

IntructionMemory instMem(.PC_out(PC_out), .InstructionMemOut(Instruction));

PC pc(.clk(clk), .reset(reset), .halt(halt), .PC_out(PC_out), .mux1(mux1));

branchMUX MUX1( .branchMUX_out(mux1), .clk(clk), .jump(jump), .signExtAdder(adder2out), .PCadder(PCAdderOut), .branchGate(branchGateout));

PCAdder Adder1(.PC_in(PC_out), .PCAdderOut(PCAdderOut));

reg_signExt_mux MUX2(.regFile(r2), .ALUSrc(ALUSrc), .mux2out(mux2out), .signExt(signExtout));

SignExtended signExt(.Instruction(Instruction), .signExtout(signExtout));

SignExtPCAdder Adder2(.PC(PC_out), .signExt(signExtout), .SignExtPCAdderOut(adder2out));

BranchGate andGate(.ALU(branchGate), .branch(branch), .BranchGateOut(branchGateout));

ControlUnit controlUnit(.Instruction(Instruction), .branch(branch), .jump(jump), .mem_read_write(mem_read_write),
.mem_to_reg(mem_to_reg), .ALUOp(ALUOp), .ALUSrc(ALUSrc), .RegWrite(RegWrite), .halt(halt));

ALUControl aluControl(.ALUOp(ALUOp), .Instruction(Instruction), .ALUControlOut(ALUControlOut));

DataMemoryMUX MUX3(.ALU(ALUout), .MemToReg(mem_to_reg), .mux3out(mux3out));
/*
module DataMemoryMUX(
input [15:0] dataMem,
input [15:0] ALU,
input MemToReg,
output reg [15:0] mux3Out
);
*/

endmodule