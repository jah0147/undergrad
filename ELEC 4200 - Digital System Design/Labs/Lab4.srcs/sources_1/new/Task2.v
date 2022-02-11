`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/10/2021 08:37:36 PM
// Design Name: 
// Module Name: Task2
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


module Task2(
    input e,
    input s,
    input r,
    output q,
    output notQ
);
    wire s1;
    wire r1;

//Gated SR Latch
and #4 (s1, e, s);
and #4 (r1, e, r);

nor #4 (q, r1, notQ);
nor #4 (notQ, s1, q);

endmodule
