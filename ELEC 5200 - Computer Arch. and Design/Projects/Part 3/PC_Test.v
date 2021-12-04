`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 10/27/2021 09:25:16 PM
// Design Name: 
// Module Name: PC_Test
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


module PC_Test(
);

reg clk; //the clock
reg reset; //resets PC
reg [9:0] MUX2; //the input from MUX2 will change the count on PC
wire PC;

PC DUT (.clk(clk), .reset(reset), .MUX2(MUX2), .PC(PC));

initial begin
clk = 0;
reset = 0;
MUX2 = 0;

#10 
clk = 1;
MUX2 = 1;

#11
clk = 0;

#20 
clk = 1;
reset = 1;
MUX2 = 2;
#30 $finish;
end

endmodule
