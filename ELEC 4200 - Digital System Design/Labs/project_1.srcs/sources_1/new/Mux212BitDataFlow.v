`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 01/21/2021 08:40:50 AM
// Design Name: 
// Module Name: Mux212BitDataFlow
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


module Mux212BitDataFlow(
    input [1:0] x,
    input [1:0] y,
    input s,
    output [1:0] m
    );
    
    wire[1:0] m, x, y;
    assign #3 m = (x & ~s) | (y & s);
endmodule
