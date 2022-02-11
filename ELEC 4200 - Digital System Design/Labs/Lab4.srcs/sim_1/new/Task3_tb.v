`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/10/2021 09:15:49 PM
// Design Name: 
// Module Name: Task3_tb
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


module Task3_tb(

    );
    reg d;
    reg e;
    wire q;
    wire notQ;
    
     Task3 DUT (.d(d), .e(e), .q(q), .notQ(notQ));
           
           initial begin
           #200 $finish; //runs simulation 100 times
           end
           
           initial begin
           d = 0;
           e = 0;
           #10 //10
           d = 1;
           #10 //20
           e = 1;
           #10 //30
           d = 0;
           #10 //40
           d = 1;
           #10 //50
           e = 0;
           #10 //60
           d = 0;
           #10 //70
           d = 1;
           #10 //80
           d = 0;
           #10 //90
           e = 1;
           #10 //100
           d = 1;
           #10 //110
           d = 0;
           end
endmodule
