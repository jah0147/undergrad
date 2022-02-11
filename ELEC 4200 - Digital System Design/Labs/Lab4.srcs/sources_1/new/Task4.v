`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/10/2021 10:04:39 PM
// Design Name: 
// Module Name: Task4
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


module Task4(
    input D, 
    input Clk, 
    output reg Q
    );
    always @ (posedge Clk)
    if(Clk) 
    begin
    Q <= D;
    end 
endmodule
