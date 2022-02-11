`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/03/2021 11:41:19 PM
// Design Name: 
// Module Name: TFlipFlop
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


module TFlipFlop(t, enable, Clk, clr, q);

input t;
input enable;
input Clk;
input clr;
output reg q;


always@(posedge Clk, negedge clr)
    begin
    if (enable)
    begin
    if(~clr)
        q <= 1'b0;
    else
        q <= q ^ t;
end
end
endmodule
