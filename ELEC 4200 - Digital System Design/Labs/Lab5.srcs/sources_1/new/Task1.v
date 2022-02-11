`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/05/2021 03:39:15 PM
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
input clk,
input reset, 
input a,

output reg yout 
);


parameter S0 = 2'b00,
S1 = 2'b01,
S2 = 2'b10,
S3 = 2'b11;



reg [1:0] state,next_state;


always @ (posedge clk or negedge reset) begin
if (~reset)
state <= S0; 
else
state <= next_state;
end

always @ (*) begin
case (state)
S0:begin
if (a==1)
next_state = S1;
else
next_state = S0;
end
S1:begin
if (a==1)
next_state = S2;
else
next_state = S0;
end
S2:begin
if (a==1)
next_state = S3;
else
next_state = S0;
end
S3:begin
if (a==1)
next_state = S1;
else
next_state = S0;
end
default: next_state = S0;
endcase
end

always @ (*) begin
case (state)
S0,S1,S2: yout = 1'b0;
S3:begin
if (a==1)
yout = 1'b1;
else
yout = 1'b0;
end

default: yout = 1'b0;
endcase
end

endmodule