`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: Jacob Howard
// 
// Create Date: 02/10/2021 07:22:04 PM
// Design Name: S-R Latch
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


module Task1(
    input s,
    input r,
    output q,
    output notQ
    );
    //SR Latch
    nor #4 (q, r, notQ);
    nor #4 (notQ, s, q);
    
endmodule
