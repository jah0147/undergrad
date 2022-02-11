`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/23/2021 09:48:19 PM
// Design Name: 
// Module Name: Task3_divider
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


module Task3_divider(
  input Clk,
   output reg Q
   );
   
   reg [27:0] counter = 28'd0;
   parameter DIVISOR = 28'd5000000;
   always @(posedge Clk)

   begin
       counter <= counter + 28'd1;
       if (counter >=(DIVISOR-1))
           counter <= 28'd0;
       Q <= (counter<DIVISOR/2)?1'b1:1'b0;
   end
endmodule
