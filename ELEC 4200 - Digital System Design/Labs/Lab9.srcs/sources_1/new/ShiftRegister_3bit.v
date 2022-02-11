`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/24/2021 08:06:44 PM
// Design Name: 
// Module Name: ShiftRegister_3bit
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


module ShiftRegister_3bit(clk, SI, SO);
input clk,SI; 
    output SO; 
    reg [2:0] tmp; 
      always @(posedge clk) 
        begin 
          tmp = tmp << 1; 
          tmp[0] = SI; 
        end 
        assign SO  = tmp[2]; 
    endmodule 
