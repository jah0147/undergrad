`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/23/2021 08:05:58 PM
// Design Name: 
// Module Name: Task4
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


module Task4(
    input pulse, //500Hz clock
    input [3:0] v, //first digit
    //input z, //second digit
    output reg [7:0] AN, 
    output reg [6:0] seg0, //7 segment display
    output lock_signal
    );
    
    wire clk_out1;
    reg z;
    
 clk_wiz_0 clockingwizard (.clk_in1(pulse), .clk_out1(clk_out1), .locked(lock_signal));
        always @(pulse)
        begin
            if (pulse)
            begin
                AN = 8'b11111110;
                case(v)
                    0   :seg0=7'b0000001;
                    1   :seg0=7'b1001111;
                    2   :seg0=7'b0010010;
                    3   :seg0=7'b0000110;
                    4   :seg0=7'b1001100;
                    5   :seg0=7'b0100100;
                    6   :seg0=7'b0100000;
                    7   :seg0=7'b0001111;
                    8   :seg0=7'b0000000;
                    9   :seg0=7'b0000100;
                    default: seg0=7'bx;
                endcase
            end
        else
        begin
        z = v;
        
            begin
                AN = 8'b11111101;
                case(z)
                    0   :seg0=7'b0000001;
                    1   :seg0=7'b1001111;
                    2   :seg0=7'b0010010;
                    3   :seg0=7'b0000110;
                    4   :seg0=7'b1001100;
                    5   :seg0=7'b0100100;
                    6   :seg0=7'b0100000;
                    7   :seg0=7'b0001111;
                    8   :seg0=7'b0000000;
                    9   :seg0=7'b0000100;
                    default: seg0=7'bx;
                endcase
            end
        end 
        end  
endmodule

    /* assign AN = 8'b11111110;
    always @(v)
            begin
            case(v)
             4'b0000 : begin seg0 = 7'b0000001; seg1 = 7'b0000001; end
             4'b0001 : begin seg0 = 7'b1001111; seg1 = 7'b0000001; end
             4'b0010 : begin seg0 = 7'b0010010; seg1 = 7'b0000001; end
             4'b0011 : begin seg0 = 7'b0000110; seg1 = 7'b0000001; end
             4'b0100 : begin seg0 = 7'b1001100; seg1 = 7'b0000001; end
             4'b0101 : begin seg0 = 7'b0100100; seg1 = 7'b0000001; end
             4'b0110 : begin seg0 = 7'b0100000; seg1 = 7'b0000001; end
             4'b0111 : begin seg0 = 7'b0001111; seg1 = 7'b0000001; end
             4'b1000 : begin seg0 = 7'b0000000; seg1 = 7'b0000001; end
             4'b1001 : begin seg0 = 7'b0000100; seg1 = 7'b0000001; end
             
             4'b1010 : begin seg0 = 7'b0000001; seg1 = 7'b1001111; end
             4'b1011 : begin seg0 = 7'b1001111; seg1 = 7'b1001111; end
             4'b1100 : begin seg0 = 7'b0010010; seg1 = 7'b1001111; end
             4'b1101 : begin seg0 = 7'b0000110; seg1 = 7'b1001111; end
             4'b1110 : begin seg0 = 7'b1001100; seg1 = 7'b1001111; end
             4'b1111 : begin seg0 = 7'b0100100; seg1 = 7'b1001111; end
             
             default : begin seg0 = 7'b1111111; seg1 = 7'b0000001; end
        endcase
        end
    
endmodule
*/