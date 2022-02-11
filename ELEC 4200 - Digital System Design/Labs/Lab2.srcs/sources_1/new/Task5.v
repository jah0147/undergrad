`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 01/27/2021 08:41:13 PM
// Design Name: 
// Module Name: Task5
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


module Task5(
input [3:0] a,
    input [3:0] b,
    input cin,
    output [3:0] sum,
    output cout,
    output reg z,
    output reg [6:0] seg,
    output [7:0] AN
    );
    
    ////////////////////////////////4-Bit Adder////////////////////////////////////
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
    
    //////////////////////7-Segment Display with Carry LED//////////////////
    
    assign AN = 8'b11111110;
    always @(sum & z & cout)
                begin
                if(cout == 0)
                case(sum)
                 4'b0000 : begin seg = 7'b0000001; z = 1'b0; end //0
                 4'b0001 : begin seg = 7'b1001111; z = 1'b0; end //1
                 4'b0010 : begin seg = 7'b0010010; z = 1'b0; end //2
                 4'b0011 : begin seg = 7'b0000110; z = 1'b0; end //3
                 4'b0100 : begin seg = 7'b1001100; z = 1'b0; end //4
                 4'b0101 : begin seg = 7'b0100100; z = 1'b0; end //5
                 4'b0110 : begin seg = 7'b0100000; z = 1'b0; end //6
                 4'b0111 : begin seg = 7'b0001111; z = 1'b0; end //7
                 4'b1000 : begin seg = 7'b0000000; z = 1'b0; end //8
                 4'b1001 : begin seg = 7'b0000100; z = 1'b0; end //9
                 
                 //2 Digit LED
                 4'b1010 : begin seg = 7'b0000001; z = 1'b1; end //10
                 4'b1011 : begin seg = 7'b1001111; z = 1'b1; end //11
                 4'b1100 : begin seg = 7'b0010010; z = 1'b1; end //12
                 4'b1101 : begin seg = 7'b0000110; z = 1'b1; end //13
                 4'b1110 : begin seg = 7'b1001100; z = 1'b1; end //14
                 4'b1111 : begin seg = 7'b0100100; z = 1'b1; end //15   
                 
                 default : begin seg = 7'b1111111; z = 1'b0; end //default case
                 
            endcase
            else 
            case(sum)
            4'b0000 : begin seg = 7'b0100000; z = 1'b1; end //16
            4'b0001 : begin seg = 7'b0001111; z = 1'b0; end //17
            4'b0010 : begin seg = 7'b0000000; z = 1'b0; end //18
            
            default : begin seg = 7'b1111111; z = 1'b0; end //default case
            endcase
            end
            
endmodule
