`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 11/15/2021 03:37:58 PM
// Design Name: 
// Module Name: CPU_Test
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


module CPU_Test();
reg clk, reset;
reg [2:0] Inr;
wire [15:0] OutValue;
wire [15:0] ALUout;
wire [15:0] r2;
wire [15:0] r1;
reg [4:0] control;
wire [15:0] PC_out;
wire [15:0] Instruction;
wire [15:0] mux1;
wire [15:0] PCAdderOut;
wire [15:0] mux2out;
wire [15:0] signExtout;
wire[15:0] adder2out;
wire branchGate;

wire branch; //andGate input
wire jump; //mux1 input
wire mem_read_write; //data mem input
wire mem_to_reg; //mux3 input
wire [2:0] ALUOp; //1-6
wire ALUSrc; //mux2 input
wire RegWrite; //RegFile input
wire halt; //PC input

wire [15:0] dataMemOut;

wire [15:0] mux3out;
/* all simulation results
CPU DUT1(.clk(clk), .r1(r1), .r2(r2), .ALUout(ALUout),
 .reset(reset), .Inr(Inr), .OutValue(OutValue),
.PC_out(PC_out), .Instruction(Instruction), .mux1(mux1),
.PCAdderOut(PCAdderOut), .mux2out(mux2out), .signExtout(signExtout),
.adder2out(adder2out), .branchGate(branchGate), .branch(branch),.jump(jump),
.mem_read_write(mem_read_write), .mem_to_reg(mem_to_reg), .ALUOp(ALUOp),
.ALUSrc(ALUSrc), .RegWrite(RegWrite), .halt(halt), .dataMemOut(dataMemOut),
.mux3out(mux3out));
*/
CPU DUT1(
.clk(clk),
.jump(jump),
.reset(reset),
.halt(halt),
.Instruction(Instruction),
.PC_out(PC_out),
.signExtout(signExtout),
.ALUout(ALUout),
.branchGate(branchGate),
.dataMemOut(dataMemOut), 
.mux3out(mux3out));
//ALU DUT2(.ALUout(ALUout), .r1(r1), .mux2(r2));

initial begin
clk = 0;
reset = 0;
Inr = 0;
#10 reset = 1;
#10 reset = 0;

//r1 = 1;
//r2 = 1;
//control = 1;

end
always #10 clk = ~clk;

endmodule
