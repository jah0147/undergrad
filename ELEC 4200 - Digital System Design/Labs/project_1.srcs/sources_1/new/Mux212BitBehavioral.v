`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 01/21/2021 08:54:05 AM
// Design Name: 
// Module Name: Mux212BitBehavioral
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


module Mux212BitBehavioral(
    input [1:0] x,
    input [1:0] y,
    input s,
    output [1:0] m
    );
    reg [1:0] m;
    always @ (x or y or s)
    begin
        if (s==0)
            m = x;
        else
            m = y;
    end
endmodule
