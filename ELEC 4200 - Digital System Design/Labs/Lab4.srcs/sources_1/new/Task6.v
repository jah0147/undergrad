`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/10/2021 11:24:14 PM
// Design Name: 
// Module Name: Task6
// Project Name: d ff with synch reset
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


module Task6(
    input D, 
    input Clk, 
    input reset, 
    output reg Q
    );
    
    always @(posedge Clk) 
    if (reset
    )begin
    Q <= 1'b0;
    end else
     begin
     Q <= D;
     end 
endmodule
