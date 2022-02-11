`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/05/2021 04:15:50 PM
// Design Name: 
// Module Name: Task3_tb
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


module Task3_tb();

reg clk,reset;
wire [3:0] out_seq;
  
Task3 s1(clk,reset,out_seq);
  
initial
begin
clk=0;
#2 reset=1;
#1 reset=0;
#30 $finish;
end
  
  
initial
forever
#2 clk=~clk;
endmodule
