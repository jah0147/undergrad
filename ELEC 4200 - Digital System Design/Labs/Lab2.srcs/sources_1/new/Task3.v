`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 01/27/2021 07:47:13 PM
// Design Name: 
// Module Name: Task3
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


module Task3(
    input [3:0] a,
    output [4:0] z
    );
    //truth tables into code
    assign z[0]=(~a[3])&(~a[2])&(~a[1])+(~a[3])&(~a[2])&a[0]+a[2]&a[1]&(~a[0]);
        assign z[1]=(~a[3])&(~a[2])&(~a[0])+(~a[3])&(~a[2])&(~a[0])+a[2]&a[1]&a[0];
        assign z[2]=~(a[3])&(~a[1])&a[0]+(~a[2])&a[1]&(~a[0])+a[3]&(~a[0]);
        assign z[3]=(~a[2])&a[1]&a[0]+a[2]&(~a[1])+a[3]&a[0];
        assign z[4]=a[2]&a[1]&(~a[0])+a[3];
endmodule
