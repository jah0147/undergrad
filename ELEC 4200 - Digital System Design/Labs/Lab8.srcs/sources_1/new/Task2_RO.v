`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/10/2021 07:47:37 PM
// Design Name: 
// Module Name: Task2_RO
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


module Task2_RO(
input in, output out
    );
    (* ALLOW_COMBINATIONAL_LOOPS = "TRUE" *)
    (* DONT_TOUCH = "TRUE" *)  wire w1, w2, w3, w4, w5, w6;
    //first RO level 5
    begin
    and #5 (w1, in, w6);
    not #5 (w2, w1);
    not #5 (w3, w2);
    not #5 (w4, w3);
    not #5 (w5, w4);
    not #5 (w6, w5);
    assign w6 = out;
    end

endmodule
