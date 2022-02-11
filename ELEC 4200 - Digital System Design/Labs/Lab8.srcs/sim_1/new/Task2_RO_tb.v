`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/10/2021 08:00:13 PM
// Design Name: 
// Module Name: Task2_RO_tb
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


module Task2_RO_tb();
reg in;
wire out;
wire w1, w2, w3, w4, w5, w6;

Task2_RO DUT (.in(in), .out(out));

assign w1 = DUT.w1;
assign w2 = DUT.w2;
assign w3 = DUT.w3;
assign w4 = DUT.w4;
assign w5 = DUT.w5;
assign w6 = DUT.w6;

        initial begin
        #1550 $finish; //runs simulation 100 times
        end
        
        initial begin
        in = 0;
        #150 in = 1;
        
        end
endmodule
