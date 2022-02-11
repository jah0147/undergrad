`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company:
// Engineer:
//
// Create Date: 02/03/2021 10:39:09 PM
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
    input [1:0] a,
    input [1:0] b,
    output [2:0] lt_gt_or_eq
    );

    wire [3:0] ROM_addr;
    reg [2:0] ROM [15:0];

   assign ROM_addr = {a[1:0], b[1:0]};
   assign lt_gt_or_eq = ROM[ROM_addr];

   begin
   initial $readmemb("memory.mem", ROM, 0, 15);
   end
endmodule
