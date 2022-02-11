`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 01/27/2021 07:27:51 PM
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
    input [3:0] v,
    output reg z,
    output reg [6:0] seg,
    output [7:0] AN
        );
    assign AN = 8'b11111110;
    always @(v)
            begin
            case(v)
             4'b0000 : begin seg = 7'b0000001; z = 1'b0; end
             4'b0001 : begin seg = 7'b1001111; z = 1'b0; end
             4'b0010 : begin seg = 7'b0010010; z = 1'b0; end
             4'b0011 : begin seg = 7'b0000110; z = 1'b0; end
             4'b0100 : begin seg = 7'b1001100; z = 1'b0; end
             4'b0101 : begin seg = 7'b0100100; z = 1'b0; end
             4'b0110 : begin seg = 7'b0100000; z = 1'b0; end
             4'b0111 : begin seg = 7'b0001111; z = 1'b0; end
             4'b1000 : begin seg = 7'b0000000; z = 1'b0; end
             4'b1001 : begin seg = 7'b0000100; z = 1'b0; end
             
             4'b1010 : begin seg = 7'b0000001; z = 1'b1; end
             4'b1011 : begin seg = 7'b1001111; z = 1'b1; end
             4'b1100 : begin seg = 7'b0010010; z = 1'b1; end
             4'b1101 : begin seg = 7'b0000110; z = 1'b1; end
             4'b1110 : begin seg = 7'b1001100; z = 1'b1; end
             4'b1111 : begin seg = 7'b0100100; z = 1'b1; end
             
             default : begin seg = 7'b1111111; z = 1'b0; end
        endcase
        end
    
endmodule
