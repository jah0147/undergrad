`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company:
// Engineer: Jacob Howard
//
// Create Date: 02/03/2021 09:51:43 PM
// Design Name: 8-to-3 Priority Encoder
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
    input wire [7:0] v,
    input wire E1,
    output reg E0,
    output reg GS,
    output reg [2:0] y
    );
    wire [9:0] S;
    assign S = {E1, v[7:0]};
    //Checks if switch E1 is on
        //If on, all LEDs light up
   always @(S)
    begin
    casex(S)
    9'b1xxxxxxxx : begin y = 3'b111; GS = 1'b1; E0 = 1'b1; end
    9'b011111111 : begin y = 3'b111; GS = 1'b1; E0 = 1'b0; end
    9'b0xxxxxxx0 : begin y = 3'b000; GS = 1'b0; E0 = 1'b1; end
    9'b0xxxxxx01 : begin y = 3'b001; GS = 1'b0; E0 = 1'b1; end
    9'b0xxxxx011 : begin y = 3'b010; GS = 1'b0; E0 = 1'b1; end
    9'b0xxxx0111 : begin y = 3'b011; GS = 1'b0; E0 = 1'b1; end
    9'b0xxx01111 : begin y = 3'b100; GS = 1'b0; E0 = 1'b1; end
    9'b0xx011111 : begin y = 3'b101; GS = 1'b0; E0 = 1'b1; end
    9'b0x0111111 : begin y = 3'b110; GS = 1'b0; E0 = 1'b1; end
    9'b001111111 : begin y = 3'b111; GS = 1'b0; E0 = 1'b1; end
    endcase
    end

endmodule
