`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 10/27/2021 09:59:34 PM
// Design Name: 
// Module Name: ControlUnit_Test
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


module ControlUnit_Test();
reg [2:0] opcode;
wire branch;
wire jump;
wire mem_read_write;
wire mem_to_reg;
wire ALUOp;
wire ALUSrc;
wire RegWrite;
wire halt;

ControlUnit DUT(.opcode(opcode), .branch(branch), .jump(jump),
 .mem_read_write(mem_read_write), .mem_to_reg(mem_to_reg), .ALUOp(ALUOp),
  .ALUSrc(ALUSrc), .RegWrite(RegWrite), .halt(halt));

initial begin
#10
opcode = 3'b000;
#20 opcode = 3'b001;
#30 opcode = 3'b010;
#40 $finish;
end  
  
endmodule
