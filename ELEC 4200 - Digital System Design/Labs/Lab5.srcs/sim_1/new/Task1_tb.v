`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/05/2021 03:56:58 PM
// Design Name: 
// Module Name: Task1_tb
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


module Task1_tb();
// veriog testbench design Code your state diagram of given fsm

reg clk;
reg reset;
reg a;

wire yout;

//instantiation of design fsm module
Task1 DUT (.clk(clk),.reset(reset),.a(a),.yout(yout));

//clock input generation
initial begin
clk = 1'b1;
forever #5 clk =~clk;
end

//test inputs generation
initial begin
$dumpfile("dump.vcd");
$dumpvars;
reset = 1'b0;a = 1'b0;
#20 reset = 1'b1;a = 1'b0;
#15 reset = 1'b1;a = 1'b1;
#15 reset = 1'b1;a = 1'b1;
#15 reset = 1'b1;a = 1'b1;
#15 reset = 1'b1;a = 1'b1;
#15 reset = 1'b1;a = 1'b1;
#15 reset = 1'b1;a = 1'b1;
#15 reset = 1'b1;a = 1'b1;
#15 reset = 1'b1;a = 1'b0;
#15 reset = 1'b1;a = 1'b1;
#15 reset = 1'b1;a = 1'b1;
#15 reset = 1'b1;a = 1'b1;
#15 reset = 1'b1;a = 1'b0;
#20 $finish;
end

endmodule
