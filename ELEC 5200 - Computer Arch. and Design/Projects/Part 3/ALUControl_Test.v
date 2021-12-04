`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 10/27/2021 10:42:54 PM
// Design Name: 
// Module Name: ALUControl_Test
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


module ALUControl_Test();

reg ALUOp;
reg [8:6] InstructionMemory;
wire [4:0]control;

ALUControl DUT (.ALUOp(ALUOp), .InstructionMemory(InstructionMemory), .control(control));

initial begin
#10
ALUOp = 0;
InstructionMemory = 3'b000;
#20
ALUOp = 1;
InstructionMemory = 3'b000;
#30 $finish;
end

endmodule
