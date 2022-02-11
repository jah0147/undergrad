`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 01/27/2021 09:44:05 PM
// Design Name: 
// Module Name: Task6
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


module Task6(
input [3:0] a,
    input [3:0] b,
    input cin,
    output [3:0] sum,
    output cout
    );
    wire cout1;
    wire cout2;
    wire cout3;
    wire [3:0] p;
    wire [3:0] g;
    
    //first adder
    assign p[0] = a[0] | b[0];
    assign g[0] = a[0] & b[0];
    assign sum[0] = a[0] ^ b[0] ^ cin;
    assign cout1 = g[0] | (p[0] & cin);
    
    //seccond adder
    assign p[1] = a[1] | b[1];
    assign g[1] = a[1] & b[1];
    assign sum[1] = a[1] ^ b[1] ^ cout1;
    assign cout2 = g[1] | (p[1] & cout1);
    
    //third adder
    assign p[2] = a[2] | b[2];
    assign g[2] = a[2] & b[2];
    assign sum[2] = a[2] ^ b[2] ^ cout2;
    assign cout3 = g[2] | (p[2] & cout2);
    
    //fourth adder
    assign p[3] = a[3] | b[3];
    assign g[3] = a[3] & b[3];
    assign sum[3] = a[3] ^ b[3] ^ cout3;
    assign cout = g[3] | (p[3] & cout3);
endmodule
