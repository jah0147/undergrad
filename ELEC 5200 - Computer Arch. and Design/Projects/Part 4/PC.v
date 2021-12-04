`timescale 1ns / 1ps
module PC(
input [15:0] mux1,
input halt,
input clk, //the clock
input reset, //resets PC
output reg [15:0] PC_out  //the output of pc will tell instuction memory where to point
);
//assign mux1 = 0; //seting pc to 0 initiall

always @(posedge clk | reset | halt) begin

if (halt == 0) begin
    if (reset == 1) begin //if reset is active, reset pc to 0
    PC_out = 0; //resets PC to 0
    end

    else begin  //if reset is not active, then PC will equal MUX2
    //PC_out = 0;
    PC_out = mux1;
    end
    //PC_out = reg_signExt_mux_out; //mux2 is theh/jump location PC mux. It will either equad PC+1 or PC +branc
end

else begin
//if halt do nothing  
end
end
endmodule