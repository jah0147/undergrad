`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/23/2021 05:58:55 PM
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


module Task1(
    input a0,
    input a1,
    input a2,
    input a3,
    input s0,
    input s1,
    output reg z
    );
    
    //4-1 mux using if else statements
    always @ (a0 or a1 or a2 or a3 or s0 or s1)
    
    begin
    if (s1 == 0 & s0 == 0)
    z = a0;
    else if ((s1 == 0) & (s0 == 1))
    z = a1;
    else if ((s1 == 1) & (s0 == 0))
    z = a2;
    else if ((s1 ==1) & (s0 == 1))
    z = a3;
    end
    
endmodule
