`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: Jacob Howard
// 
// Create Date: 02/03/2021 07:39:31 PM
// Design Name: 3-to-8 line decoder
// Module Name: Task1
// Project Name: 3-to-8 line decoder
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


module Task1(
    input [2:0] x,//3 bit input
    output [7:0] m //8 bit output
    );
    
    assign m[0] = (~(x[2] | x[1] | x[0])); //m[0] is 1 when all bits of x are == 0
    assign m[1] = (~(x[2] | x[1]) & x[0]); //~a & ~ b & c = m[1]
    assign m[2] = (~(x[2] | x[0]) & x[1]); //~a & b & ~c
    assign m[3] = (~x[2] & x[1] & x[0]); //~a & b & c
    assign m[4] = x[2] & ~(x[1] | x[0]); //a & ~b & ~c
    assign m[5] = x[2] & ~x[1] & x[0]; //a & ~b & c
    assign m[6] = x[2] & x[1] & ~x[0]; // a & b & ~c
    assign m[7] = x[2] & x[1] & x[0]; //a & b & c
    
endmodule
