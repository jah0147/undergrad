`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/03/2021 09:11:41 PM
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
reg [3:0] D;
reg Clk, load, reset;
wire [3:0] Q;
integer k;
    
    Task1 DUT (.D(D), .Clk(Clk), .load(load), .reset(reset), .Q(Q));
    
        initial begin
        #300 $finish; //runs simulation 100 times
        end
        
        initial begin
        load = 0;
        reset = 0;
        D = 0;
        #60 load = 1; //at 60ns
        #20 load = 0; //80ns
        #40 load = 1; //120 ns
        #20 load = 0; //140 ns
        #15 reset = 1; //122 ns
        #40 load = 1; //195 ns
        #5 load = 0; //215 ns
        #20 reset = 0; //240 ns
        #50 load = 1; //280ns
        end
        
        initial begin
        D = 0;
        #20 D = 4'b0101;
        #60 D = 4'b1001;
        end
        
         //clock
           initial begin
           for (k = 0; k <= 100; k = k+1)
           begin
               Clk = 0;
               #10 Clk = 1;
               #10;
               Clk = 0;
               end
               
end           
endmodule
