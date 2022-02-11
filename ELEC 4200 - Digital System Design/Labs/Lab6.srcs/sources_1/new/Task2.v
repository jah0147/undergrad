`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/23/2021 06:33:15 PM
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
    input [3:0] a,
    input enable,
    output reg [3:0] z,
    output reg enableLED
    );
    //Grey Code Generator using case statement
    always @ (a or enable)
    begin
    enableLED = 0;
    if (enable == 1)
    begin
    enableLED = 0;
    case(a)
        4'b0000 : begin z = 4'b0000; end
        4'b0001 : begin z = 4'b0001; end
        4'b0010 : begin z = 4'b0011; end 
        4'b0011 : begin z = 4'b0010; end
        4'b0100 : begin z = 4'b0110; end
        4'b0101 : begin z = 4'b1110; end  
        4'b0110 : begin z = 4'b1010; end
        4'b0111 : begin z = 4'b1011; end  
        4'b1000 : begin z = 4'b1011; end  
        4'b1001 : begin z = 4'b1001; end         
        default : begin z = 4'b1111; end
    endcase
    end
    else
    z = 4'b1111; 
    enableLED = 1;
    end
endmodule
