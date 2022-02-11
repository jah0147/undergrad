`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company:
// Engineer:
//
// Create Date: 01/21/2021 08:24:48 AM
// Design Name:
// Module Name: Mux21Gate
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


module Mux21Gate(
    input x,
    input y,
    input s,
    output m
    );
    wire notS;
    wire Int1;
    wire Int2;
    wire Int3;

    not notS (OutNotS, s);
    and Int1(And1, OutNotS, x);
    and Int2 (And2,s, y);
    or Int3 (m, And1, And2);

endmodule
