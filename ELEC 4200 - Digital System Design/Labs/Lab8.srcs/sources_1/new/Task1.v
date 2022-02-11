`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/10/2021 07:43:40 PM
// Design Name: 
// Module Name: Task1
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


module Task1(input in1, 
output out1
);
(* DONT_TOUCH = "TRUE" *) wire w1; //prevents optimiation
not #5 (w1, in1);
not #5 (out1, w1);

endmodule
