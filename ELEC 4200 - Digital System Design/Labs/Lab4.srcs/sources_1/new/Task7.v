`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/10/2021 11:39:55 PM
// Design Name: D_ff_with_ce_and_synch_reset_behavior
// Module Name: Task7
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


module Task7(
    input D, 
    input Clk, 
    input reset, 
    input ce, 
    output reg Q
    );
    
    always @(posedge Clk) 
    if (reset)
    begin
    Q <= 1'b0;
    end else 
    if (ce) begin
    Q <= D;
    end 
endmodule
