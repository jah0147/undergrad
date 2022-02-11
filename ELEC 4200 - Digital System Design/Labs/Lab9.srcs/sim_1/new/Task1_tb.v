`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/24/2021 09:33:51 PM
// Design Name: 
// Module Name: Task1_tb
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


module Task1_tb();
reg [2:0] multiplicand;
reg [2:0] multiplier;
reg clk, start;
wire [5:0] product;
wire done;

integer k;

Task1_new MUL (.multiplicand(multiplicand), .multiplier(multiplier), 
.clk(clk), .start(start), .product(product), .done(done));

initial begin
#500 $finish; //runs simulation 100 times
end

//clock
        initial begin
        for (k = 0; k <= 1000; k = k+1)
        begin
        clk = 0;
        #5 clk = 1;
        #5;
        clk = 0;
        end
        end
//start
initial begin
start = 0;
#30 start = 1;
#10 start = 0;
#100 start = 1;
#10 start = 0;
#100 start = 1;
#10 start = 0;
end

initial begin
multiplicand = 3'b111;
multiplier = 3'b101;
#140
multiplicand = 3'b100;
multiplier = 3'b001;
#110
multiplicand = 3'b111;
multiplier = 3'b100;
end
endmodule
