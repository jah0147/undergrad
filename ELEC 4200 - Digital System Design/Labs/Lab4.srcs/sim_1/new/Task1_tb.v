`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company:
// Engineer:
//
// Create Date: 02/10/2021 08:12:40 PM
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


module Task1_tb(
    );
    reg s;
    reg r;
    wire q;
    wire notQ;

    Task1 DUT (.s(s), .r(r), .q(q), .notQ(notQ));

    initial begin
    #100 $finish; //runs simulation 100 times
    end

    initial begin
    s = 0;
    r = 0;
    #10
    s = 1;
    #10
    s = 0;
    #10
    r = 1;
    #10
    r = 0;
    s = 1;
    #10
    s = 0;
    r = 1;
    #10
    s = 1;
    r = 0;
    #10
    r = 1;
    s = 0;
    #10
    s = 1;
    end
endmodule
