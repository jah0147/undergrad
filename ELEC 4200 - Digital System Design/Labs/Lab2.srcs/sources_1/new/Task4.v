`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 01/27/2021 08:00:31 PM
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
    input a,
    input b,
    input cin,
    output sum,
    output cout
    );
    assign sum = a ^ b ^ cin;
    assign cout = a & b | a & cin | b & cin; 
    
endmodule
