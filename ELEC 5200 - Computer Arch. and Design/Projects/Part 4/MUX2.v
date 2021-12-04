module reg_signExt_mux( //for testing outputs, not actual memory module
input [15:0] regFile, //r2
input [15:0] signExt, //immidiate
input ALUSrc,
output reg [15:0] mux2out
);

//assign ALUSrc = 0; //testing

always @(ALUSrc)
begin
    if (ALUSrc == 1) begin
    mux2out = signExt;
    end
else 
mux2out = regFile;
end


endmodule