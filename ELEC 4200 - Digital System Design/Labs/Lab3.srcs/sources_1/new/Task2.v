`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: Jacob Howard
// 
// Create Date: 02/03/2021 08:24:34 PM
// Design Name: 74138
// Module Name: Task2
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


module Task2(
    input [2:0] x,
    input g1,
    input g2a_n,
    input g2b_n,
    output [7:0] y
    );
    
    assign y[0] = !((g1 & ~g2a_n & ~g2b_n) & (~(x[2] | x[1] | x[0])));
    assign y[1] = !((g1 & ~g2a_n & ~g2b_n) & (~(x[2] | x[1]) & x[0]));
    assign y[2] = !((g1 & ~g2a_n & ~g2b_n) & (~(x[2] | x[0]) & x[1])); 
    assign y[3] = !((g1 & ~g2a_n & ~g2b_n) & (~x[2] & x[1] & x[0]));
    assign y[4] = !((g1 & ~g2a_n & ~g2b_n) & (x[2] & ~(x[1] | x[0])));
    assign y[5] = !((g1 & ~g2a_n & ~g2b_n) & (x[2] & ~x[1] & x[0]));
    assign y[6] = !((g1 & ~g2a_n & ~g2b_n) & (x[2] & x[1] & ~x[0]));
    assign y[7] = !((g1 & ~g2a_n & ~g2b_n) & (x[2] & x[1] & x[0]));
    
    
endmodule
