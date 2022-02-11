`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/10/2021 08:44:10 PM
// Design Name: 
// Module Name: Task3_R1
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


module Task3_R1(input in, output out);
(* ALLOW_COMBINATIONAL_LOOPS = "TRUE" *)
  (* DONT_TOUCH = "TRUE" *)  wire r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
      
  //2nd R0 lvl 6
  begin
      and #5 (r1, in, r10);
      not #5 (r2, r1);
      not #5 (r3, r2);
      not #5 (r4, r3);
      not #5 (r5, r4);
      not #5 (r6, r5);
      not #5 (r7, r6);
      not #5 (r8, r7);
      not #5 (r9, r8);
      not #5 (out, r9);
      assign r10 = out;
  end
  
  
endmodule
