`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/24/2021 07:34:07 PM
// Design Name: 
// Module Name: accumulator_3bit
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


module accumulator_3bit(clk, D, Q);
input clk; 
    input  [2:0] D; 
    output [2:0] Q; 
    reg    [2:0] tmp;  
    
      always @(posedge clk) 
        begin 
            tmp = tmp + D; 
        end 
      assign Q = tmp; 
    endmodule 
