`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/10/2021 10:20:04 PM
// Design Name: 
// Module Name: Task4_tb
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


module Task4_tb(

    );
    reg D;
    reg Clk;
    wire Q;
    integer k;
    
    Task4 DUT (.D(D), .Clk(Clk), .Q(Q));
    
    initial begin
    #150 $finish; //runs simulation 150 times
    end
    
    initial begin
    D = 0;
    #30 D = 1;
    #30 D = 0;
    #40 D = 1;
    #20 D = 0;
    end
    
    //clock
    initial begin
    for (k = 0; k <= 6; k = k+1)
    begin
        Clk = 0;
        #10 Clk = 1;
        #10;
        Clk = 0;
        end
       
    end
endmodule
