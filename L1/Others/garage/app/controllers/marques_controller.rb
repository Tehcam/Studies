class MarquesController < ApplicationController
  before_action :set_marque, only: %i[ show edit update destroy ]

  # GET /marques or /marques.json
  def index
    @marques = Marque.all
  end

  # GET /marques/1 or /marques/1.json
  def show
  end

  # GET /marques/new
  def new
    @marque = Marque.new
  end

  # GET /marques/1/edit
  def edit
  end

  # POST /marques or /marques.json
  def create
    @marque = Marque.new(marque_params)

    respond_to do |format|
      if @marque.save
        format.html { redirect_to @marque, notice: "Marque was successfully created." }
        format.json { render :show, status: :created, location: @marque }
      else
        format.html { render :new, status: :unprocessable_entity }
        format.json { render json: @marque.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /marques/1 or /marques/1.json
  def update
    respond_to do |format|
      if @marque.update(marque_params)
        format.html { redirect_to @marque, notice: "Marque was successfully updated." }
        format.json { render :show, status: :ok, location: @marque }
      else
        format.html { render :edit, status: :unprocessable_entity }
        format.json { render json: @marque.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /marques/1 or /marques/1.json
  def destroy
    @marque.destroy
    respond_to do |format|
      format.html { redirect_to marques_url, notice: "Marque was successfully destroyed." }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_marque
      @marque = Marque.find(params[:id])
    end

    # Only allow a list of trusted parameters through.
    def marque_params
      params.require(:marque).permit(:nom, voitures_attributes:[:id, :immatriculation, :_destroy, :couleur])
    end
end
