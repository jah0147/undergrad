`timescale 1ns / 1ps

//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: Jacob Howard
// 
// Create Date: 01/27/2021 05:31:00 PM
// Design Name: 4 to 7 Seg Decoder
// Module Name: Task1
// Project Name: Lab2
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
    input [3:0] a,
    output reg [6:0] z,
    output [7:0] AN
    );
    assign AN = 8'b11111110;
    always @(a)
        begin
        case(a)
         4'b0000 : begin z = 7'b0000001; end
         4'b0001 : begin z = 7'b1001111; end
         4'b0010 : begin z = 7'b0010010; end
         4'b0011 : begin z = 7'b0000110; end
         4'b0100 : begin z = 7'b1001100; end
         4'b0101 : begin z = 7'b0100100; end
         4'b0110 : begin z = 7'b0100000; end
         4'b0111 : begin z = 7'b0001111; end
         4'b1000 : begin z = 7'b0000000; end
         4'b1001 : begin z = 7'b0000100; end
         default : begin z = 7'b1111111; end
    endcase
    end
endmodule
