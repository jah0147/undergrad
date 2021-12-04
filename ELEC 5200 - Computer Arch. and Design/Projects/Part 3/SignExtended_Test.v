`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 10/27/2021 10:16:14 PM
// Design Name: 
// Module Name: SignExtended_Test
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


module SignExtended_Test();

reg [15:0] InstructionMemory;
wire [9:0] signIout; //sign extended immediates output. Max value should not be over 10-bits

SignExtended DUT (.InstructionMemory(InstructionMemory), .signIout(signIout));

initial begin
#10 InstructionMemory = 16'b1000000000111100; //func4 = 1111 or 15dec bc sb type
#20 $finish;
end

endmodule
