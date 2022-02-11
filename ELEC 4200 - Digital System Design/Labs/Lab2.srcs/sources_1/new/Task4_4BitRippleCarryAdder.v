`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 01/27/2021 08:07:53 PM
// Design Name: 
// Module Name: Task4_4BitRippleCarryAdder
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


module Task4_4BitRippleCarryAdder(
    input [3:0] a,
    input [3:0] b,
    input cin,
    output [3:0] sum,
    output cout
    );
    wire cout1;
    wire cout2;
    wire cout3;
    
    //first adder
    assign sum[0] = a[0] ^ b[0] ^ cin;
    assign cout1 = a[0]&b[0] | a[0]&cin | b[0]&cin;
    
    //seccond adder
    assign sum[1] = a[1] ^ b[1] ^ cout1;
    assign cout2 = a[1]&b[1] | a[1]&cout1 | b[1]&cout1;
    
    //third adder
    assign sum[2] = a[2] ^ b[2] ^ cout2;
    assign cout3 = a[2]&b[2] | a[2]&cout2 | b[0]&cout2;
    
    //fourth adder
    assign sum[3] = a[3] ^ b[3] ^ cout3;
    assign cout = a[3]&b[3] | a[3]&cout3 | b[3]&cout3;
    
endmodule
