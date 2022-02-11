`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/10/2021 11:52:58 PM
// Design Name: 
// Module Name: Task8
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


module Task8(
    input Clk, 
    input reset_n, 
    input T, 
    output reg Q
    );
    
    always @(negedge Clk)
    if (!reset_n) 
    Q <= 1'b0;
    else if (T) 
    Q <= ~Q;
endmodule
