`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company:
// Engineer:
//
// Create Date: 01/21/2021 08:32:36 AM
// Design Name:
// Module Name: Mux212BitGate
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


module Mux212BitGate(
    input [1:0] x,
    input [1:0] y,
    input s,
    output [1:0] m
    );
    wire notS;
    wire [1:0] Int1;
    wire [1:0] Int3;

      not notS (OutNotS, s);
      and Int1[1:0] (And1, OutNotS, x);
      and Int2[1:0] (And2,s, y);
      or Int3[1:0] (m, And1, And2);
endmodule
