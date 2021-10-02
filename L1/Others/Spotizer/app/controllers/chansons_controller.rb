class ChansonsController < ApplicationController
  before_action :set_chanson, only: %i[ show edit update destroy ]

  # GET /chansons or /chansons.json
  def index
    @chansons = Chanson.all
  end

  # GET /chansons/1 or /chansons/1.json
  def show
  end

  # GET /chansons/new
  def new
    @chanson = Chanson.new
  end

  # GET /chansons/1/edit
  def edit
  end

  # POST /chansons or /chansons.json
  def create
    @chanson = Chanson.new(chanson_params)

    respond_to do |format|
      if @chanson.save
        format.html { redirect_to @chanson, notice: "Chanson was successfully created." }
        format.json { render :show, status: :created, location: @chanson }
      else
        format.html { render :new, status: :unprocessable_entity }
        format.json { render json: @chanson.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /chansons/1 or /chansons/1.json
  def update
    respond_to do |format|
      if @chanson.update(chanson_params)
        format.html { redirect_to @chanson, notice: "Chanson was successfully updated." }
        format.json { render :show, status: :ok, location: @chanson }
      else
        format.html { render :edit, status: :unprocessable_entity }
        format.json { render json: @chanson.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /chansons/1 or /chansons/1.json
  def destroy
    @chanson.destroy
    respond_to do |format|
      format.html { redirect_to chansons_url, notice: "Chanson was successfully destroyed." }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_chanson
      @chanson = Chanson.find(params[:id])
    end

    # Only allow a list of trusted parameters through.
    def chanson_params
      params.require(:chanson).permit(:titre, :date_sortie, :album_id, :artiste_id)
    end
end
